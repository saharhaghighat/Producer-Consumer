public class Messages {
    private String PhoneNumber;
    private String Message;

    public Messages(String phoneNumber, String message) {
        PhoneNumber = phoneNumber;
        Message = message;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getMessage() {
        return Message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "PhoneNumber='" + PhoneNumber + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
