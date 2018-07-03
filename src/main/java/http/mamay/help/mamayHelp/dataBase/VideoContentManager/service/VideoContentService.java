package http.mamay.help.mamayHelp.dataBase.VideoContentManager.service;

import http.mamay.help.mamayHelp.dataBase.VideoContentManager.model.VideoContent;
import http.mamay.help.mamayHelp.dataBase.VideoContentManager.repository.VideoContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoContentService {

    @Autowired
    private VideoContentRepository videoContentRepository;


    public VideoContent getRandomVideo() {
        List<VideoContent> videos = videoContentRepository.findAll();
        int e = (int) (Math.random() * (videos.size() - 1));
        return videos.get(e);
    }


}
