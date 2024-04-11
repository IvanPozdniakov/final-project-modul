import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class CapitalControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(true);
        String level = request.getParameter("level");
        String startNewGame = request.getParameter("newGame");

        if("true".equals(startNewGame)){
            session.removeAttribute("currentQuestion");
            session.removeAttribute("currentQuestionIndex");
            session.removeAttribute("message");
        }

        List<Question> questionList = QuestionBase.getInstance().getQuestionList();

        if(!questionList.isEmpty()) {
            session.setAttribute("currentQuestion", questionList.get(0));
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("level", level);
            session.setAttribute("totalQuestions", questionList.size());
            getServletContext().getRequestDispatcher("/quiz.jsp").forward(request, response);
        }else{
            response.getWriter().println("Error: There are no questions.");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(true);
        Question currentQuestion = (Question) session.getAttribute("currentQuestion");
        String userAnswerStr = request.getParameter("userAnswer");

        if(userAnswerStr != null & !userAnswerStr.isEmpty()){
            try {
                int userAnswer = Integer.parseInt(userAnswerStr);

                if (userAnswerStr == currentQuestion.getRightAnswer()) {
                    session.getAttribute("message", "Correct!");
                }else {
                    session.getAttribute("message", "Incorrect!");
                }
            }catch (NumberFormatException e){
                session.setAttribute("message", "Error!");
            }
        }

        List<Question> questions = QuestionBase.getInstance().getQuestionList();
        int currentQuestionIndex = (Integer) session.getAttribute("currentQuestionIndex");

        if("true".equals(request.getParameter("restartButton"))){
            restartGame(session);
            response.sendRedirect("quiz.jsp");
            return;
        }
        session.getAttribute("currentQuestionIndex", currentQuestionIndex);
        session.getAttribute("totalQuestion", questions.size());

        if(currentQuestionIndex < questions.size() - 1){
            Question nextQuestion = questions.get(currentQuestionIndex + 1);
            session.getAttribute("currentQuestion", nextQuestion);
            session.getAttribute("currentQuestionIndex", currentQuestionIndex + 1);
            response.sendRedirect("quiz.jsp");
        }else {
            response.sendRedirect("quizResult.jsp");
        }
    }

    private void restartGame(HttpSession session){
        session.removeAttribute("currentQuestion");
        session.removeAttribute("currentQuestionIndex");
        session.removeAttribute("message");

        List<Question> questions = QuestionBase.getInstance().getQuestionList();
        Question firstQuestion = questions.get(0);
        session.setAttribute("currentQuestion", firstQuestion);
        session.setAttribute("currentQuestionIndex", 0);
    }


}
