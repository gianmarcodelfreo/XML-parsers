let xmlhttp;

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

  // // Creazione di un nuovo studente
  //
  // const newStudentInfo = `
  //       <student>
  //         <name>Giorgio</name>
  //         <surname>Sandroni</surname>
  //         <age>17</age>
  //         <gender>Maschio</gender>
  //         <dateOfBirth>25/12/2004</dateOfBirth>
  //       </student>
  // `;
  //
  // // aggiunta del nodo utilizzando innerHTML
  // xmlInput.getElementsByTagName("class")[1].innerHTML += newStudentInfo;

  // Metodo utilizzando le API DOM
  // Ci creiamo tutti gli elementi di cui abbiamo bisogno

  // const newStudent = xmlInput.createElement("student");
  // const newName= xmlInput.createElement("name");
  // newName.textContent="Giorgio";
  // const newSurname= xmlInput.createElement("surname");
  // newSurname.textContent="Sandroni";
  // const newAge= xmlInput.createElement("age");
  // newAge.textContent="17";
  // const newGender= xmlInput.createElement("gender");
  // newGender.textContent="Maschio";
  // const newDateOfBirth= xmlInput.createElement("dateOfBirth");
  // newDateOfBirth.textContent="25/12/2004";

  // // "Appendiamo" gli elementi appena creati

  // newStudent.appendChild(newName);
  // newStudent.appendChild(newSurname);
  // newStudent.appendChild(newAge);
  // newStudent.appendChild(newGender);
  // newStudent.appendChild(newDateOfBirth);

  // xmlInput.getElementsByTagName("class")[1].appendChild(newStudent);

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
