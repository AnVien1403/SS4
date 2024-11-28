import com.example.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    // Danh sách giả lập cơ sở dữ liệu
    private List<Player> players = new ArrayList<>();

    // Thêm người chơi
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Lấy tất cả người chơi
    public List<Player> getAllPlayers() {
        return players;
    }

    // Cập nhật thông tin người chơi
    public void updatePlayer(int playerId, Player updatedPlayer) {
        for (Player player : players) {
            if (player.getPlayerId() == playerId) {
                player.setName(updatedPlayer.getName());
                player.setFullName(updatedPlayer.getFullName());
                player.setAge(updatedPlayer.getAge());
                player.setIndexId(updatedPlayer.getIndexId());
                break;
            }
        }
    }

    // Xóa người chơi
    public void deletePlayer(int playerId) {
        players.removeIf(player -> player.getPlayerId() == playerId);
    }
}
