// document.addEventListener("DOMContentLoaded", () => {
//   fetch("/api/crops")
//     .then((response) => response.json())
//     .then((data) => {
//       const buttonList = document.getElementById("button_list");
//       data.forEach((crop) => {
//         const button = document.createElement("button");
//         button.textContent = crop.name;
//         buttonList.appendChild(button);
//       });
//     })
//     .catch((error) => {
//       console.error("Error fetching crops:", error);
//     });
// });
document.addEventListener("DOMContentLoaded", () => {
  // 더미 데이터 정의
  const dummyData = [
    { name: "사과" },
    { name: "귤" },
    { name: "망고" },
    { name: "오렌지" },
    { name: "농작물 1" },
    { name: "농작물 2" },
    { name: "농작물 3" },
    { name: "농작물 4" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
    { name: "농작물 5" },
  ];

  // 버튼 리스트 요소 선택
  const buttonList = document.getElementById("button_list");

  // 더미 데이터를 기반으로 버튼 생성
  dummyData.forEach((crop) => {
    const button = document.createElement("button");
    button.textContent = crop.name;
    buttonList.appendChild(button);
  });
});
