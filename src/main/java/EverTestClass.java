import com.evernote.edam.error.EDAMErrorCode;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.thrift.transport.TTransportException;

public class EverTestClass {
    public static void main(String[] args) throws Exception {

        String token = initEverClass();
        EverClass demo = null;
        try {
            demo = new EverClass(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            demo.listNotes();
            demo.createNote();
            demo.searchNotes();
            demo.updateNoteTag();
        } catch (EDAMUserException e) {
            // These are the most common error types that you'll need to
            // handle
            // EDAMUserException is thrown when an API call fails because a
            // parameter was invalid.
            if (e.getErrorCode() == EDAMErrorCode.AUTH_EXPIRED) {
                System.err.println("Your authentication token is expired!");
            } else if (e.getErrorCode() == EDAMErrorCode.INVALID_AUTH) {
                System.err.println("Your authentication token is invalid!");
            } else if (e.getErrorCode() == EDAMErrorCode.QUOTA_REACHED) {
                System.err.println("Your authentication token is invalid!");
            } else {
                System.err.println("Error: " + e.getErrorCode().toString()
                        + " parameter: " + e.getParameter());
            }
        } catch (EDAMSystemException e) {
            System.err.println("System error: " + e.getErrorCode().toString());
        } catch (TTransportException t) {
            System.err.println("Networking error: " + t.getMessage());
        }


    }

    public static String initEverClass() {
        final String AUTH_TOKEN = "S=s1:U=9583a:E=174d40fd31e:C=16d7c5ea340:P=1cd:A=en-devtoken:V=2:H=e740013f0bad65847e41cc2e00920a6c";

        String token = System.getenv("AUTH_TOKEN");
        if (token == null) {
            token = AUTH_TOKEN;
        }
        return token;
    }

}
