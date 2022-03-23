package wyu.xwen.ossService.service;

import org.springframework.web.multipart.MultipartFile;

public interface AliyunService {
    String uploadUserPhoto(MultipartFile file);

    String uploadCarImag(MultipartFile file);

    String uploadPetImag(MultipartFile file);

    String UploadCommunityThumb(MultipartFile file);

    String uploadRepairImag(MultipartFile file,String folder);
}
