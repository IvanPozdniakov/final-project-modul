public class Question {
    private final String question;
    private final String answerOption1;
    private final String answerOption2;
    private final String answerOption3;
    private final String answerOption4;
    private final int rightAnswer;

    public String getQuestion() {
        return question;
    }

    public String getAnswerOption1() {
        return answerOption1;
    }

    public String getAnswerOption2() {
        return answerOption2;
    }

    public String getAnswerOption3() {
        return answerOption3;
    }

    public String getAnswerOption4() {
        return answerOption4;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public Question(String question, String answerOption1, String answerOption2, String answerOption3, String answerOption4, int rightAnswer) {
        this.question = question;
        this.answerOption1 = answerOption1;
        this.answerOption2 = answerOption2;
        this.answerOption3 = answerOption3;
        this.answerOption4 = answerOption4;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (rightAnswer != question1.rightAnswer) return false;
        if (!question.equals(question1.question)) return false;
        if (!answerOption1.equals(question1.answerOption1)) return false;
        if (!answerOption2.equals(question1.answerOption2)) return false;
        if (!answerOption3.equals(question1.answerOption3)) return false;
        return answerOption4.equals(question1.answerOption4);
    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + answerOption1.hashCode();
        result = 31 * result + answerOption2.hashCode();
        result = 31 * result + answerOption3.hashCode();
        result = 31 * result + answerOption4.hashCode();
        result = 31 * result + rightAnswer;
        return result;
    }
}
