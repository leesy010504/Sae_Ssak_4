document.addEventListener("DOMContentLoaded", function () {
  const yearInput = document.getElementById("year-input");
  const regionInput = document.getElementById("region-input");
  const searchButton = document.getElementById("search-button");
  const form = document.querySelector(".insert-form");

  function enableSearchButton() {
    searchButton.disabled = !(yearInput.value && regionInput.value);
  }

  yearInput.addEventListener("input", enableSearchButton);
  regionInput.addEventListener("input", enableSearchButton);

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const year = yearInput.value;
    const region = regionInput.value;

    fetch("/???", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ year: year, region: region }),
    })
        .then((response) => response.json())
        .then((data) => {
          drawChart(data);
        })
        .catch((error) => {
          console.error("Error:", error);
        });
  });

  function drawChart(data) {
    const month = {
      months: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월",
      ],
    };

    const canvas = document.getElementById("weatherChart2");
    const ctx = canvas.getContext("2d");
    const canvasWidth = (canvas.width = canvas.offsetWidth);
    const canvasHeight = (canvas.height = canvas.offsetHeight);

    const padding = 60;
    const chartWidth = canvasWidth - 2 * padding;
    const chartHeight = canvasHeight - 2 * padding;
    const barWidth = chartWidth / month.months.length;
    const barSpacing = 30;
    const maxRainfall = Math.max(...data.rainfall);
    const maxTemperature = Math.max(...data.temperature);

    const maxYAxisRainfall = Math.ceil(maxRainfall / 10) * 10;
    const maxYAxisTemperature = Math.ceil(maxTemperature / 10) * 10;

    function drawAxes() {
      ctx.strokeStyle = "#000";
      ctx.lineWidth = 0.5;
      ctx.beginPath();
      ctx.moveTo(padding, padding);
      ctx.lineTo(padding, canvasHeight - padding);
      ctx.stroke();

      ctx.beginPath();
      ctx.moveTo(canvasWidth - padding, padding);
      ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
      ctx.stroke();

      ctx.beginPath();
      ctx.moveTo(padding, canvasHeight - padding);
      ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
      ctx.stroke();

      ctx.fillStyle = "#000";
      ctx.font = "14px Arial";
      month.months.forEach((month, i) => {
        const x = padding + i * barWidth + barWidth / 2;
        const y = canvasHeight - padding + 20;
        ctx.textAlign = "center";
        ctx.fillText(month, x, y);
      });

      ctx.font = "14px Arial";
      ctx.textAlign = "right";
      ctx.fillText("(mm)", canvasWidth - padding + 10, padding - 20);
      for (let i = 0; i <= 5; i++) {
        const y = padding + chartHeight - (i / 5) * chartHeight;
        const text = Math.round((maxYAxisRainfall / 5) * i);
        ctx.fillText(text, canvasWidth - padding + 10, y);
      }
    }

    let animationProgress = 0;
    const animationSteps = 60;

    function animateGraph() {
      animationProgress += 1;
      const animationRatio = animationProgress / animationSteps;

      ctx.clearRect(padding, padding, chartWidth, chartHeight);

      ctx.fillStyle = "rgba(54, 162, 235, 0.5)";
      data.rainfall.forEach((rain, i) => {
        const x = padding + i * barWidth;
        const y =
            padding +
            chartHeight -
            (rain / maxYAxisRainfall) * chartHeight * animationRatio;
        const height = (rain / maxYAxisRainfall) * chartHeight * animationRatio;
        ctx.fillRect(x + barSpacing / 2, y, barWidth - barSpacing, height);
      });

      if (animationProgress < animationSteps) {
        requestAnimationFrame(animateGraph);
      }
    }

    drawAxes();
    animateGraph();
  }
});