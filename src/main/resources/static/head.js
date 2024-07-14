document.addEventListener("DOMContentLoaded", function () {
  const yearInput = document.getElementById("year-input");
  const regionInput = document.getElementById("region-input");
  const searchButton = document.getElementById("search-button");

  function updateButtonState() {
    const year = yearInput.value;
    const region = regionInput.value.trim();
    const isActive = year !== "" && region !== "";
    searchButton.disabled = !isActive;
    searchButton.classList.toggle("active", isActive);
  }

  yearInput.addEventListener("change", updateButtonState);
  regionInput.addEventListener("input", updateButtonState);

  window.handleSearch = function (event) {
    event.preventDefault();
    const year = yearInput.value;
    const region = regionInput.value.trim();
    if (searchButton.classList.contains("active")) {
      // Perform search action here
      console.log(`Searching for year: ${year}, region: ${region}`);
    }
  };
});
