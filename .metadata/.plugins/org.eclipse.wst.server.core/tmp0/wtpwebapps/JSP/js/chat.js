 "use strict";

    const socket = new WebSocket("ws://localhost:8080/JSP/broadcasting"); 

    const nickname = document.querySelector("#nickname");
    const chatList = document.querySelector(".chatting-list");
    const chatInput = document.querySelector(".chatting-input");
    const sendButton = document.querySelector(".send-button");
    const displayContainer = document.querySelector(".display-container");
    
    chatInput.addEventListener("keypress", (event) => {
      if (event.keyCode === 13) {
    	
        send();
        chatInput.value = "";
      }
    });
   
    function send() {
      const param = {
        name: nickname.value,
        msg: chatInput.value,
        time: getCurrentTime(),
        
      };
      // 자신의 화면에도 메시지 추가
      const selfItem = new LiModel(param.name, param.msg, param.time);
      selfItem.makeLi();

      
      socket.send(JSON.stringify(param));
    }
    sendButton.addEventListener("click", () => {
    	  send();
    	  chatInput.value = "";
    	});
    function getCurrentTime() {
    	  const now = new Date();
    	  const hours = now.getHours().toString().padStart(2, "0");
    	  const minutes = now.getMinutes().toString().padStart(2, "0");
    	  const currentTime = `${hours}:${minutes}`;
    	  return currentTime;
    	}


    socket.addEventListener("message", (event) => {
      const data = JSON.parse(event.data);
      const { name, msg, time } = data;
      const item = new LiModel(name, msg, time);
      item.makeLi();
      displayContainer.scrollTo(0, displayContainer.scrollHeight);
    });

    function LiModel(name, msg, time) {
      this.name = name;
      this.msg = msg;
      this.time = time;

      this.makeLi = () => {
    	  
        const li = document.createElement("li");
        li.classList.add(nickname.value === this.name ? "sent" : "received");
        const dom = `<span class="profile">
          <span class="user">${this.name}</span>
          <img class="image" src="https://i.pinimg.com/736x/ac/2c/43/ac2c43b48b6a307cbe1844ed73e55eef.jpg" alt="any">
        </span>
        <span class="message">${this.msg}</span>
        <span class="time">${this.time}</span>`;
        li.innerHTML = dom;
        chatList.appendChild(li);
      };
    }