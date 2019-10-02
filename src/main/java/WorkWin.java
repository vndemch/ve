import com.evernote.edam.error.EDAMErrorCode;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.thrift.transport.TTransportException;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI;

public class WorkWin {
    public final String redirect_uri = "https://oauth.vk.com/blank.html ";
    public final int app_id = 7151702;
    public final String secret_id = "Zbdpdei3peTcTCSE4U33";
    public final String code = "1de9d282f5f81a5c69";
    static final String AUTH_TOKEN = "S=s1:U=9583a:E=174d40fd31e:C=16d7c5ea340:P=1cd:A=en-devtoken:V=2:H=e740013f0bad65847e41cc2e00920a6c";

    private WinForm winForm;
    public VkApiClient vk;
    public UserActor actor;
    public WorkWin() {
        this.winForm = new WinForm();
        try {
            VKClass vkclass = new VKClass(app_id, secret_id, redirect_uri, code);
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private boolean connectEver() {
        boolean result = false;
        final String AUTH_TOKEN = "S=s1:U=9583a:E=174d40fd31e:C=16d7c5ea340:P=1cd:A=en-devtoken:V=2:H=e740013f0bad65847e41cc2e00920a6c";
        return result;
    }
}
