function renderTable(reimbs) {
  for (const item of reimbs) {
    const tr = document.createElement("tr");
    const amounttd = document.createElement("td");
    const submittedtd = document.createElement("td");
    const resolvedtd = document.createElement("td");
    const descriptiontd = document.createElement("td");
    const statustd = document.createElement("td");
    const typeid = document.createElement("td");
    
    amounttd.innerText = item.amount;
    submittedtd.innerText = item.submitted.month + "/" + item.submitted.dayOfMonth + "/" + item.submitted.year;
    if(item.resolved != null)
    {resolvedtd.innerText = item.resolved.month + "/" + item.resolved.dayOfMonth + "/" + item.resolved.year;}
    else
    {resolvedtd.innerText = ""}
    descriptiontd.innerText = item.desc;
    statustd.innerText = item.status_s;
    typeid.innerText = item.type_s;
    
    tr.append(amounttd, submittedtd, resolvedtd , descriptiontd, statustd, typeid);

    document.getElementById("ReimbTableB").append(tr);
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

asyncFetch("http://localhost:8080/EmployeeReimburseM/viewreimb.json", renderTable);








/*

async function addMonster() {
  const monster = {
    name: document.getElementById("monName").value,
    type: {
      type: document.getElementById("monType").value,
      furry: document.getElementById("monFur").value,
      paws: document.getElementById("monPaws").value,
    },
  };
  const fetched = await fetch("http://localhost:8080/HallowsMonsters/monster.json", {
    method: "post",
    body: JSON.stringify(monster),
  });
  const json = await fetched.text();
  const rows = document.getElementById('hallowsTableBody').innerHTML='';
  asyncFetch("http://localhost:8080/HallowsMonsters/all.json", renderTable);
}

document.getElementById("monSubmit").addEventListener("click", addMonster);
*/