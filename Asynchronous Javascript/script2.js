// //Complete the given scaffold to implement all the functionalities mentioned in the problem Statement.
// const sentences =
//   `The quick brown fox jumps over the lazy dog.
//   Sphinx of black quartz, judge my vow.
//   Pack my box with five dozen liquor jugs.
//   How vexingly quick daft zebras jump!`
// ;
// function startTest() {
//   let seconds = 30;
//   const timeOut = setTimeout(() => {
//     document.getElementById("sentence").innerHTML = sentences;
//     document.getElementById("input").disabled = false;
//     document.getElementById("start-btn").disabled = true;
//   }, seconds);
//   document.getElementById("timer").innerHTML = seconds;
//   const timer = setInterval(() => {
//     document.getElementById("timer").innerHTML = seconds--;
//     if (seconds <= 0) {
//       clearInterval(timer);
//       clearTimeout(timeOut);
//       showResult();
//     }
//   }, 1000);
// }
// document
//   .getElementById("start-btn")
//   .addEventListener("click", () => startTest());
// function showResult() {
//   const typingInputEle = document.getElementById("input");
//   let typedWords = typingInputEle.value.trim();
//   typedWords = typedWords.split(" ");
//   document.getElementById("result").style.display = "block";
//   document.getElementById("start-btn").disabled = true;
// 	typingInputEle.disabled=true;
//   document.getElementById("retry-btn").addEventListener("click", () => {
//     document.getElementById("result").style.display = "none";
//     document.getElementById("start-btn").disabled = false;
//     typingInputEle.value = "";
//   });
//   calculateWpmAndAccuracy(typedWords);
// }

// function calculateWpmAndAccuracy(typedWords) {
//   const wpm = document.getElementById("speed");
//   const accuracy = document.getElementById("accuracy");
//   let correctWords = 0;
//   typedWords.forEach((word, index) => {
//     if (word === sentences.split(" ")[index]) {
//       correctWords++;
//     }
//   });
//   const typedWordsLength = typedWords.length;
//   const accuracyPercentage = ((correctWords / typedWordsLength) * 100).toFixed(
//     2
//   );
//   const speed = correctWords * 2;
//   wpm.innerHTML = `${speed}`;
//   accuracy.innerHTML = `${accuracyPercentage}`;
// }
