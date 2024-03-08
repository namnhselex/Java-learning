public class SocialMediaFacade {
    private Facebook facebook;
    private LinkedIn linkedIn;
    private Twistter twitter;

    public SocialMediaFacade(Facebook facebook, LinkedIn linkedIn, Twistter twitter) {
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.twitter = twitter;
    }

    public void share(String message){
        facebook.setMessage(message);
        linkedIn.setMessage(message);
        twitter.setMessage(message);
        facebook.share();
        linkedIn.share();
        twitter.share();
    }
}
