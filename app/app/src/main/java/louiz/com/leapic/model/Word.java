package louiz.com.leapic.model;

public class Word {
    private int id,wordType,topicId,learn,favorite;
    private String name,spell,ex,exMean;
    private byte[] pic;

    public Word(int id, int wordType, int topicId, int learn, int favorite, String name, String spell, String ex, String exMean, byte[] pic) {
        this.id = id;
        this.wordType = wordType;
        this.topicId = topicId;
        this.learn = learn;
        this.favorite = favorite;
        this.name = name;
        this.spell = spell;
        this.ex = ex;
        this.exMean = exMean;
        this.pic = pic;
    }

    public Word(int id,String name,String spell,String exMean,byte[] pic) {
        this.id = id;
        this.name = name;
        this.spell = spell;
        this.exMean = exMean;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordType() {
        return wordType;
    }

    public void setWordType(int wordType) {
        this.wordType = wordType;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getLearn() {
        return learn;
    }

    public void setLearn(int learn) {
        this.learn = learn;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getExMean() {
        return exMean;
    }

    public void setExMean(String exMean) {
        this.exMean = exMean;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
