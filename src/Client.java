public class Client {
    public void share(String message) {
        SocialMediaFacade socialMediaFacade = new SocialMediaFacade(new Facebook(), new LinkedIn(), new Twistter());
        socialMediaFacade.share(message);
    }
}
