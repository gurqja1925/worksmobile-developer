# 🚀 LINE WORKS API

* UpdateAt : 2025-07-25
* API 사용 가이드 : <https://developers.worksmobile.com/kr/docs>
<br>

## 🛠️ Usage
```java
Client client = Client.accessToken(YOUR_TOKEN);
// 사용자에게 텍스트 메세지 보내기
client.bot.sendChannelMessage(BOT_ID, CHANNELID)
        .data(new Text("YOUR TEXT").getJson())
        .execute();
```
<br>

📚 Supported APIs
|API Type|	Supported|
|---|:---:|
|Bot CURD, sendMessage|✅|

🙋‍♂️ Contact
- gurqja1925@gmail.com
<br>
