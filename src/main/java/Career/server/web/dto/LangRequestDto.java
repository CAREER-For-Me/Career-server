package Career.server.web.dto;

import java.util.List;

public class LangRequestDto {
    private List<LangInfo> lang;

    public List<LangInfo> getLang() {
        return lang;
    }

    public void setLang(List<LangInfo> lang) {
        this.lang = lang;
    }

    public static class LangInfo {
        private String type;
        private String score;
        private String issueDate;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }
    }
}
