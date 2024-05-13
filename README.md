<img src="https://capsule-render.vercel.app/api?type=waving&color=1120ff&height=150&section=header&text=RabbitMq-Producer&fontColor=ffffff" />

### 🎉 소개 - Introduction
---
Spring-Cloud-Stream 과 RabbitMq 를 활용한 메세지 큐 구축 코드 입니다.

Producer 역할을 하는 코드 입니다.

코드를 실행하기 앞서 2가지를 작업을 해주셔야 정상적으로 어플리케이션이 동작하는 것을 보실 수 있습니다.

1. rabbitMq_consumer 코드를 받아주세요.
2. 도커 컨테이너를 해당 이미지를 받으시고 실행시켜야 됩니다. 도커가 없으시면 도커를 설치해주세요.
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 --restart=unless-stopped rabbitmq:management
3. Postman을 실행하여 API 요청 작업을 진행합니다.

  - http://localhost:8080/send/message

  - method : POST

  - Body : { "title" : "message send", "content" : "message queue test"

### 🌈 구성 요소
---
1. Producer : 메세지(요청)을 보내는 주체. Exchange에 메세지를 보내는(Publish) 역할 입니다.
2. Exchange : Producer 로 부터 전달받은 메세지를 어떤 Queue로 보낼지 결정하는 곳 입니다. Queue와 Exchange 사이 Routing Key가 존재 해야 합니다.
3. Queue : Consumer 가 메세지를 소비하기 전까지 메세지를 보관하는 장소 입니다.
4. Binding : Exchange 와 Queue의 관계를 정의합니다. 총 4개의 전략이 있습니다.

   - Direct Exchange : 메세지의 Routing Key와 일치하는 Binding 된 Queue 로 Routing 합니다.
   
   - Fanout Exchange : Binding 된 모든 Queue에게 메세지를 Routing 합니다.
   
   - Topic Exchange : 특정 Routing 패턴이 일치하는 Queue로 Routing 합니다.
   
   - Headers Exchange : Key-Value방식으로 정의된 Header 속성을 통해 Routing 합니다.


<img src="https://capsule-render.vercel.app/api?type=waving&color=1120ff&height=150&section=footer" />
