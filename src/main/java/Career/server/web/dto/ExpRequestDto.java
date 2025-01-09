package Career.server.web.dto;

import java.util.List;

public class ExpRequestDto {
    private List<ExpInfo> exp;

    public List<ExpInfo> getExp() {
        return exp;
    }

    public void setExp(List<ExpInfo> exp) {
        this.exp = exp;
    }

    public static class ExpInfo {
        private int gubun;
        private String instituion;
        private String startDate;
        private String endDate;

        public int getGubun() {
            return gubun;
        }

        public void setGubun(int gubun) {
            this.gubun = gubun;
        }

        public String getInstituion() {
            return instituion;
        }

        public void setInstituion(String instituion) {
            this.instituion = instituion;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }
}
