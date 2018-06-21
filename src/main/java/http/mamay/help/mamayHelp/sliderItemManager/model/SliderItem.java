package http.mamay.help.mamayHelp.sliderItemManager.model;

import javax.persistence.*;

@Entity
@Table(name = "sliderItems")
public class SliderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "src")
    private String src;
    @Column(name = "url")
    private String url;

    public SliderItem() {
    }

    public SliderItem(String src, String url) {
        this.src = src;
        this.url = url;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
