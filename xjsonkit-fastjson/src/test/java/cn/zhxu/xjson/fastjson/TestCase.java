package cn.zhxu.xjson.fastjson;


import cn.zhxu.xjson.JsonKit;
import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

import java.util.List;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new FastjsonFactory().create()).run();
    }

    @Test
    public void test2() {
        String json = "{\"czjg\": \"3\", \"zfnr\": \"车库出租住人\", \"fdzkdh\": \"\", \"fdzkxm\": \"\", \"czqzFile\": [], \"xczpFile\": [], \"zfzqzFile\": [], \"fdzkqzFile\": [], \"xfaqzrsFile\": []}";
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            JsonKit.toBean(Model.class, json);
        }
        long t1 = System.currentTimeMillis();
        System.out.println("耗时：" + (t1 - t0));
    }

    public static class Model {

        private String czjg;
        private String zfnr;
        private String fdzkdh;
        private String fdzkxm;
        private List<String> czqzFile;
        private List<String> xczpFile;
        private List<String> zfzqzFile;
        private List<String> fdzkqzFile;
        private List<String> xfaqzrsFile;

        public String getCzjg() {
            return czjg;
        }

        public void setCzjg(String czjg) {
            this.czjg = czjg;
        }

        public String getZfnr() {
            return zfnr;
        }

        public void setZfnr(String zfnr) {
            this.zfnr = zfnr;
        }

        public String getFdzkdh() {
            return fdzkdh;
        }

        public void setFdzkdh(String fdzkdh) {
            this.fdzkdh = fdzkdh;
        }

        public String getFdzkxm() {
            return fdzkxm;
        }

        public void setFdzkxm(String fdzkxm) {
            this.fdzkxm = fdzkxm;
        }

        public List<String> getCzqzFile() {
            return czqzFile;
        }

        public void setCzqzFile(List<String> czqzFile) {
            this.czqzFile = czqzFile;
        }

        public List<String> getXczpFile() {
            return xczpFile;
        }

        public void setXczpFile(List<String> xczpFile) {
            this.xczpFile = xczpFile;
        }

        public List<String> getZfzqzFile() {
            return zfzqzFile;
        }

        public void setZfzqzFile(List<String> zfzqzFile) {
            this.zfzqzFile = zfzqzFile;
        }

        public List<String> getFdzkqzFile() {
            return fdzkqzFile;
        }

        public void setFdzkqzFile(List<String> fdzkqzFile) {
            this.fdzkqzFile = fdzkqzFile;
        }

        public List<String> getXfaqzrsFile() {
            return xfaqzrsFile;
        }

        public void setXfaqzrsFile(List<String> xfaqzrsFile) {
            this.xfaqzrsFile = xfaqzrsFile;
        }
    }

}
