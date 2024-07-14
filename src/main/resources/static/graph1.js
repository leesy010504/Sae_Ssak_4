document.addEventListener("DOMContentLoaded", function () {
  // 예시 데이터: 백엔드에서 받아온 데이터
  const data = {
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
    rainfall: [50, 40, 60, 70, 90, 100, 110, 120, 80, 70, 60, 50],
    temperature: [5, 7, 10, 15, 20, 25, 30, 28, 24, 18, 10, 6],
  };

  const canvas = document.getElementById("weatherChart1");
  const ctx = canvas.getContext("2d");
  const canvasWidth = (canvas.width = canvas.offsetWidth);
  const canvasHeight = (canvas.height = canvas.offsetHeight);

  // 그래프 설정
  const padding = 60; // 패딩을 늘려 단위 라벨과 y축 라벨 사이 공간 확보
  const chartWidth = canvasWidth - 2 * padding;
  const chartHeight = canvasHeight - 2 * padding;
  const barWidth = chartWidth / data.months.length;
  const barSpacing = 30; // 막대 사이의 간격
  const maxRainfall = Math.max(...data.rainfall);
  const maxTemperature = Math.max(...data.temperature);

  // Y축 최대값 설정
  const maxYAxisRainfall = Math.ceil(maxRainfall / 10) * 10;
  const maxYAxisTemperature = Math.ceil(maxTemperature / 10) * 10;

  // x, y축 그리기
  function drawAxes() {
    // 왼쪽 Y축 그리기 (기온)
    ctx.strokeStyle = "#000";
    ctx.lineWidth = 0.5;
    ctx.beginPath();
    ctx.moveTo(padding, padding);
    ctx.lineTo(padding, canvasHeight - padding);
    ctx.stroke();

    // 오른쪽 Y축 그리기 (강수량)
    ctx.beginPath();
    ctx.moveTo(canvasWidth - padding, padding);
    ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
    ctx.stroke();

    // X축 그리기
    ctx.beginPath();
    ctx.moveTo(padding, canvasHeight - padding);
    ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
    ctx.stroke();

    // X축 라벨 그리기 (월)
    ctx.fillStyle = "#000";
    ctx.font = "14px Arial";
    data.months.forEach((month, i) => {
      const x = padding + i * barWidth + barWidth / 2;
      const y = canvasHeight - padding + 20;
      ctx.textAlign = "center";
      ctx.fillText(month, x, y);
    });

    // 왼쪽 Y축 라벨 그리기 (기온)
    ctx.font = "14px Arial";
    ctx.textAlign = "right";
    ctx.fillText("(°C)", padding - 10, padding - 20); // 단위 추가
    for (let i = 0; i <= 5; i++) {
      const y = padding + chartHeight - (i / 5) * chartHeight;
      const text = Math.round((maxYAxisTemperature / 5) * i);
      ctx.fillText(text, padding - 10, y);
    }
  }

  // 초기 애니메이션 상태
  let animationProgress = 0;
  const animationSteps = 60; // 애니메이션 프레임 수

  // 애니메이션 함수
  function animateGraph() {
    animationProgress += 1;
    const animationRatio = animationProgress / animationSteps;

    // 그래프 지우기
    ctx.clearRect(padding, padding, chartWidth, chartHeight);

    // 꺾은선 그래프 그리기 (기온)
    ctx.strokeStyle = "rgba(255, 99, 132, 1)";
    ctx.lineWidth = 2;
    ctx.beginPath();
    data.temperature.forEach((temp, i) => {
      const x = padding + i * barWidth + barWidth / 2;
      const y =
        padding +
        chartHeight -
        (temp / maxYAxisTemperature) * chartHeight * animationRatio;
      if (i === 0) {
        ctx.moveTo(x, y);
      } else {
        ctx.lineTo(x, y);
      }
    });
    ctx.stroke();

    // 애니메이션 진행 상태 확인
    if (animationProgress < animationSteps) {
      requestAnimationFrame(animateGraph);
    }
  }

  // 축 그리기
  drawAxes();

  // 애니메이션 시작
  animateGraph();
});
