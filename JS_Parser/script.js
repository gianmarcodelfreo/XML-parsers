if (window.XMLHttpRequest) {
  xmlhttp = new XMLHttpRequest(); // code for IE7+, Firefox, Chrome, Opera, Safari
}

xmlhttp.onload = () => {
  const xmlInput = new DOMParser().parseFromString(
    xmlhttp.responseText,
    "text/xml"
  );

  const list = document.getElementById("content");

  const student = xmlInput.getElementsByTagName("student");

  for (let i = 0; i < student.length; i++) {
    const studentInfo = {
      name: student[i].getElementsByTagName("name")[0].textContent,
      surname: student[i].getElementsByTagName("surname")[0].textContent,
      age: student[i].getElementsByTagName("age")[0].textContent,
      gender: student[i].getElementsByTagName("gender")[0].textContent,
      dataOfBirth:
        student[i].getElementsByTagName("dataOfBirth")[0].textContent,
    };

    list.innerHTML += `
      <ul class="list-group mb-5">
        <li class="list-group-item bg-secondary text-white"><b>Nome</b> ${studentInfo.name}</li>
        <li class="list-group-item"><b>Cognome</b> ${studentInfo.surname}</li>
        <li class="list-group-item"><b>Età</b> ${studentInfo.age}</li>
        <li class="list-group-item"><b>Sesso</b> ${studentInfo.gender}</li>
        <li class="list-group-item"><b>Data di nascita</b> ${studentInfo.dataOfBirth}</li>
      </ul>
    `;
  }
};

xmlhttp.open("GET", "input.xml", false);
xmlhttp.send();
