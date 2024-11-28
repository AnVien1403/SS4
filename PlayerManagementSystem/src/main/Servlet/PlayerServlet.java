

import com.example.dao.PlayerDAO;
import com.example.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayerServlet extends HttpServlet {
    private PlayerDAO playerDAO;

    @Override
    public void init() throws ServletException {
        playerDAO = new PlayerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> players = playerDAO.getAllPlayers();
        request.setAttribute("players", players);
        request.getRequestDispatcher("players.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form và tạo đối tượng Player
        String name = request.getParameter("name");
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");
        int indexId = Integer.parseInt(request.getParameter("indexId"));

        Player newPlayer = new Player(0, name, fullName, age, indexId);
        playerDAO.addPlayer(newPlayer);

        // Chuyển hướng về trang danh sách người chơi
        response.sendRedirect("players");
    }
}
