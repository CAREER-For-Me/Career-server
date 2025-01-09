package Career.server.web.dto;

import java.util.List;

public class QualRequestDto {
    private List<QualInfo> qual;

    public List<QualInfo> getQual() {
        return qual;
    }

    public void setQual(List<QualInfo> qual) {
        this.qual = qual;
    }

    public static class QualInfo {
        private String qualName;
        private String institution;
        private String issueDate;

        public String getQualName() {
            return qualName;
        }

        public void setQualName(String qualName) {
            this.qualName = qualName;
        }

        public String getInstitution() {
            return institution;
        }

        public void setInstitution(String institution) {
            this.institution = institution;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }
    }
}
