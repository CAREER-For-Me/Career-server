package Career.server.web.dto;

import java.util.List;

public class AwardRequestDto {
    private List<AwardInfo> award;

    public List<AwardInfo> getAward() {
        return award;
    }

    public void setAward(List<AwardInfo> award) {
        this.award = award;
    }

    public static class AwardInfo {
        private String awardName;
        private String instituion;
        private String issueDate;

        public String getAwardName() {
            return awardName;
        }

        public void setAwardName(String awardName) {
            this.awardName = awardName;
        }

        public String getInstituion() {
            return instituion;
        }

        public void setInstituion(String instituion) {
            this.instituion = instituion;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }
    }
}
