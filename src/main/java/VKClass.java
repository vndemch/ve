import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.exceptions.OAuthException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

public class VKClass {
    public UserActor actor = null;

    public VKClass(int _app_id, String _secret_id, String _redirect_uri, String _code) throws ClientException, ApiException {
        if(initVKConnection(_app_id, _secret_id, _redirect_uri, _code) == null) {
        System.out.println("Соединение с VK не установлено. Попробуйте еще раз");}
        else {
            System.out.println("Подключились");
        }
    }
    // Подключаемся к контакту и получаем объект UserActor actor
    private UserActor initVKConnection(int app_id, String secret_id, String redirect_uri, String code) throws ClientException, ApiException {
        //boolean res = false;
        UserAuthResponse authResponse = null;

        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

        try {
            authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(app_id, secret_id, redirect_uri, code)
                    .execute();
        } catch (OAuthException e) {
            e.getRedirectUri();
        }
        
        actor = new UserActor( authResponse.getUserId(), authResponse.getAccessToken() );

        return actor;
    }

    

}
