package com.yiqzq.miaoshasystem.imagecode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author yiqzq
 * @date 2020/6/4 22:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageCode {

    /**
     * 验证码BufferedImage对象
     */
    private BufferedImage image;

    /**
     * 验证码String值
     */
    private String code;

    /**
     * 验证码过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}