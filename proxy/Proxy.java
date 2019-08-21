import java.security.InvalidParameterException;

interface IChatRoom {
    void sendMessage(ChatUser chatUser, String message);
}

class ChatRoom implements IChatRoom {
    @Override
    public void sendMessage(ChatUser chatUser, String message) {
        System.out.println("Message send : " + message);
    }
}

class ChatRoomProxy implements IChatRoom {
    IChatRoom chatRoom;

    public ChatRoomProxy(IChatRoom inChatRoom) {
        if(inChatRoom == null) {
            throw new InvalidParameterException("ChatRoomProxy constructor does not accept null for inChatRoom parameter");
        }
        this.chatRoom = inChatRoom;
    }

    @Override
    public void sendMessage(ChatUser chatUser, String message) {
        if (chatUser.getValidated()) {
            chatRoom.sendMessage(chatUser, message);
        }
    }
}

class ChatUser {
    private boolean validated = false;

    public boolean getValidated() {
        return this.validated;
    }

    public void setValidated(boolean inValidated) {
        this.validated = inValidated;
    }
}

class Proxy {
    public static void main(String args[]) {
        // set up
        ChatRoomProxy chatRoomProxy = new ChatRoomProxy(new ChatRoom());
        ChatUser chatUser = new ChatUser();

        // we try with unvalidated user
        chatRoomProxy.sendMessage(chatUser, "I don't want to validate my account !");

        // user has to validate
        chatUser.setValidated(true);

        // now it works
        chatRoomProxy.sendMessage(chatUser, "Fine ....");

        /**
         * The process of checking user validation is handled in the proxy class. This prevents the actually chat room
         * from worrying over user details.
         */
    }
}
