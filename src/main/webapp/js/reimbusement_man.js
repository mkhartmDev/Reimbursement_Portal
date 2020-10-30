function renderTable(reimbs) {
  for (const item of reimbs) {
    const tr = document.createElement("tr");
    const identifiertd = document.createElement("td");
    const amounttd = document.createElement("td");
    const nametd = document.createElement("td");
    const submittedtd = document.createElement("td");
    const resolvedtd = document.createElement("td");
    const descriptiontd = document.createElement("td");
    const statustd = document.createElement("td");
    const typeid = document.createElement("td");
    
    identifiertd.innerText = item.reimb_id;
    nametd.innerText = item.fname + " " + item.lname;
    amounttd.innerText = "$" +  item.amount;
    submittedtd.innerText = item.submitted.month + "/" + item.submitted.dayOfMonth + "/" + item.submitted.year;
    if(item.resolved != null)
    {resolvedtd.innerText = item.resolved.month + "/" + item.resolved.dayOfMonth + "/" + item.resolved.year;}
    else
    {resolvedtd.innerText = ""}
    descriptiontd.innerText = item.desc;
    statustd.innerText = item.status_s;
    typeid.innerText = item.type_s;
    
    tr.append(identifiertd, nametd, amounttd, submittedtd, resolvedtd , descriptiontd, statustd, typeid);

    document.getElementById("ReimbTableB").append(tr);
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

async function deny() 
  {
    let aprr = window.prompt("Enter identifier to deny: ");

  const Reimburse = {
    reimb_id: aprr
  };

  const fetched = await fetch("http://localhost:8080/EmployeeReimburseM/deny.json", {
    method: "post",
    body: JSON.stringify(Reimburse)
  });

  const json = await fetched.text();
  const rows = document.getElementById('ReimbTableB').innerHTML='';
  asyncFetch("http://localhost:8080/EmployeeReimburseM/man_reimb.json", renderTable);
}

async function approve() 
  {
    let aprr = window.prompt("Enter identifier to approve: ");

  const Reimburse = {
    reimb_id: aprr
  };

  const fetched = await fetch("http://localhost:8080/EmployeeReimburseM/approve.json", {
    method: "post",
    body: JSON.stringify(Reimburse)
  });

  const json = await fetched.text();
  const rows = document.getElementById('ReimbTableB').innerHTML='';
  asyncFetch("http://localhost:8080/EmployeeReimburseM/man_reimb.json", renderTable);
}

asyncFetch("http://localhost:8080/EmployeeReimburseM/man_reimb.json", renderTable);





















