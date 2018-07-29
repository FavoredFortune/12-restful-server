//from demo and class lecture CodeFellows Java 401
//2018 July

const HOMEPAGE = "http://localhost:9090/birds";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("remove-bird");

deleteButton.addEventListener("click", (event) => {
    fetch(form.action, {
    method: "DELETE"
}).then(() => {
    window.location = HOMEPAGE;
});
});

form.addEventListener("submit", (event) => {
    event.preventDefault();
console.log(event.target.method, event.target.action);

const inputs = event.target.getElementsByTagName("input");
const speciesName = inputs[0].value;
const locationSeen = inputs[1].value;
const dateSeen = inputs[2].value;

const bird = {speciesName, locationSeen, dateSeen};
const body = JSON.stringify(bird);

fetch(event.target.action, {
    method: event.target.getAttribute("method"),
    body: body
}).then(() => {
    window.location = HOMEPAGE;
});
})
