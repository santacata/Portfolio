function inici() {
    var div=document.getElementById("divACambiar");
    div.addEventListener("mouseover", canviaColor);
    div.addEventListener("mouseout", canviaColor);
}
function canviaColor(event) {
    if (event.type === "mouseover") {
        event.target.style.backgroundColor = "red";
        event.target.style.border = "black";
    } else if (event.type === "mouseout") {
        event.target.style.backgroundColor = "pink"; 
        event.target.style.border = "white";
    }
}
window.onload=function() {
    inici();
}