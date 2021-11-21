if (window.XMLHttpRequest) {
  xmlhttp = new XMLHttpRequest(); // code for IE7+, Firefox, Chrome, Opera, Safari
}

const _FILEPATH = "../inputs/example.xml";
xmlhttp.open("GET", _FILEPATH, false);

xmlhttp.onload = () => {
  const xmlInput = new DOMParser().parseFromString(
    xmlhttp.responseText,
    "text/xml"
  );

  // Posizione di stampa degli elementi
  const list = document.getElementById("content");

  // Recupero dell'oggetto all'interno del file XML
  const student = xmlInput.getElementsByTagName("student");

  // Recupero dei dati
  for (let i = 0; i < student.length; i++) {
    const studentInfo = {
      class: `${student[i].parentElement.getAttribute("section")} ${student[
        i
      ].parentElement.getAttribute("specialization")}`,
      name: student[i].getElementsByTagName("name")[0].textContent,
      surname: student[i].getElementsByTagName("surname")[0].textContent,
      age: student[i].getElementsByTagName("age")[0].textContent,
      gender: student[i].getElementsByTagName("gender")[0].textContent,
      dateOfBirth:
        student[i].getElementsByTagName("dateOfBirth")[0].textContent,
    };

    list.innerHTML += `
      <ul class="list-group mb-5">
        <li class="list-group-item bg-secondary text-white"><b>CLASSE</b> ${studentInfo.class}</li>
        <li class="list-group-item"><b>Nome</b> ${studentInfo.name}</li>
        <li class="list-group-item"><b>Cognome</b> ${studentInfo.surname}</li>
        <li class="list-group-item"><b>Età</b> ${studentInfo.age}</li>
        <li class="list-group-item"><b>Sesso</b> ${studentInfo.gender}</li>
        <li class="list-group-item"><b>Data di nascita</b> ${studentInfo.dateOfBirth}</li>
      </ul>
    `;
  }

  // Agire sul contenuto
  const firstNameTag = xmlInput.getElementsByTagName("name")[0];
  console.log("Nome: ", firstNameTag.textContent);
  firstNameTag.innerHTML = "Linda";
  console.log("Nome: ", firstNameTag.textContent);

  // Agire sugli attributi
  const classTag = xmlInput.getElementsByTagName("class")[0];
  console.log("Attributo: ", classTag.getAttribute("specialization"));
  classTag.setAttribute("specialization", "Elettrotecnica");
  console.log("Attributo: ", classTag.getAttribute("specialization"));
};

xmlhttp.send();
