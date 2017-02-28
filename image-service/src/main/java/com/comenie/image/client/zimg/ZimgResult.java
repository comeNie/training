package com.comenie.image.client.zimg;

/**
 * Created by 波 on 2017/2/15.
 */
public class ZimgResult {

    private boolean ret;

    private ZimgInfo info;
    private ZimgError error;

    public ZimgResult() {
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ZimgInfo getInfo() {
        return info;
    }

    public void setInfo(ZimgInfo info) {
        this.info = info;
    }

    public ZimgError getError() {
        return error;
    }

    public void setError(ZimgError error) {
        this.error = error;
    }

    public String getImageUrl() {

        if (this.isRet()) {
            return ZimgClient.zimgShareUrl + this.info.getMd5();
        }
        return "";
    }


    public class ZimgError {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public class ZimgInfo {
        private String md5;

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }



}
