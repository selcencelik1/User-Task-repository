const API_URL = "/tasks";

// 📌 Tüm görevleri getir
async function getAllTasks() {
  const res = await fetch(API_URL);
  const data = await res.json();
  displayTasks(data);
}

// 📌 Yeni görev ekle
async function addTask() {
  const title = document.getElementById("title").value;
  const description = document.getElementById("description").value;
  const status = document.getElementById("status").value;
  const userId = document.getElementById("userId").value;

  const res = await fetch(`${API_URL}/byUserId/${userId}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, description, status })
  });

  if (res.ok) {
    getAllTasks();
    getAllUsers(); // Kullanıcıya ait görev listesi güncellensin
    clearForm();
  } else {
    alert("Task couldn't be added");
  }
}

// 📌 Görevleri filtrele
async function filterTasks() {
  const status = document.getElementById("filterStatus").value;
  let url = API_URL;
  if (status) url += `/byStatus?status=${status}`;

  const res = await fetch(url);
  const data = await res.json();
  displayTasks(data);
}

// 📌 Görevleri ekrana yaz
function displayTasks(tasks) {
  const list = document.getElementById("taskList");
  list.innerHTML = "";

  tasks.forEach((task) => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${task.title}</strong> - ${task.status}<br/>
      ${task.description}<br/>
      👤 User ID: ${task.userId}<br/>
    `;
    list.appendChild(li);
  });
}

// 📌 Yeni kullanıcı ekle
async function addUser() {
  const name = document.getElementById("firstName").value;
  const email = document.getElementById("email").value;

  if (!name || !email) {
    alert("Please enter name and email.");
    return;
  }

  const res = await fetch("/users", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, email })
  });

  if (res.ok) {
    alert("User created.");
    getAllUsers();
    clearUserForm();
  } else {
    const err = await res.text();
    alert("User couldn't be created:\n" + err);
  }
}

// 📌 Kullanıcı formunu temizle
function clearUserForm() {
  document.getElementById("firstName").value = "";
  document.getElementById("email").value = "";
}

// 📌 Görev formunu temizle
function clearForm() {
  document.getElementById("title").value = "";
  document.getElementById("description").value = "";
  document.getElementById("status").value = "TODO";
  document.getElementById("userId").value = "";
}

// 📌 Tüm kullanıcıları listele ve her biri için görevleri tıklayınca aç
async function getAllUsers() {
  const res = await fetch("/users");
  const users = await res.json();

  const userList = document.getElementById("userList");
  userList.innerHTML = "";

  users.forEach((user) => {
    const li = document.createElement("li");
    li.innerHTML = `
      <div class="user" data-user-id="${user.id}" style="cursor:pointer;">
        👤 <strong>${user.name}</strong> - ${user.email}
      </div>
      <ul id="tasks-for-${user.id}" style="display:none; margin-left: 20px;"></ul>
    `;
    li.querySelector(".user").addEventListener("click", async () => {
      await toggleTasks(user.id);
    });
    userList.appendChild(li);
  });
}

async function toggleTasks(userId) {
  const taskUl = document.getElementById(`tasks-for-${userId}`);
  const isVisible = taskUl.style.display === "block";

  if (isVisible) {
    taskUl.style.display = "none";
  } else {
    const res = await fetch(`/tasks/byUserId/${userId}`);
    const tasks = await res.json();

    taskUl.innerHTML = "";
    tasks.forEach((task) => {
      const li = document.createElement("li");
      li.innerHTML = `
        <strong>${task.title}</strong> - ${task.status}<br/>
        ${task.description}<br/>
      `;
      taskUl.appendChild(li);
    });

    taskUl.style.display = "block";
  }
}




// 📌 Sayfa açıldığında ilk yükleme
getAllUsers();
getAllTasks();
