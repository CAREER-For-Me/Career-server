package Career.server.web.dto;

import java.util.List;

public class EduRequestDto {
    private List<EduInfo> edu;

    public List<EduInfo> getEdu() {
        return edu;
    }

    public void setEdu(List<EduInfo> edu) {
        this.edu = edu;
    }

    public static class EduInfo {
        private int gubun;
        private String uniName;
        private int majorGubun;
        private String majorName;

        public int getGubun() {
            return gubun;
        }

        public void setGubun(int gubun) {
            this.gubun = gubun;
        }

        public String getUniName() {
            return uniName;
        }

        public void setUniName(String uniName) {
            this.uniName = uniName;
        }

        public int getMajorGubun() {
            return majorGubun;
        }

        public void setMajorGubun(int majorGubun) {
            this.majorGubun = majorGubun;
        }

        public String getMajorName() {
            return majorName;
        }

        public void setMajorName(String majorName) {
            this.majorName = majorName;
        }
    }
}
