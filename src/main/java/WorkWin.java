import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI;

public class WorkWin {
    private WinForm winForm;
    public VkApiClient vk;
    public UserActor actor;
    public WorkWin() {
        this.winForm = new WinForm();
    }

    private boolean connectVK() throws ClientException, ApiException {
        boolean res = false;
        String redirect_uri = "https://oauth.vk.com/blank.html ";
        int app_id = 7151702;
        String secret_id = "Zbdpdei3peTcTCSE4U33";
        String code = "1de9d282f5f81a5c69";
        TransportClient transportClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(transportClient);
        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(app_id, secret_id, redirect_uri, code).execute();

        actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());

        return res;
    }
}
