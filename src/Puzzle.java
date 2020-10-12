public class Puzzle {

    private String description;
    private String answer;
    private String puzzleID;
    private String roomID;

    public Puzzle(String description, String answer, String puzzleID, String roomID) {
        this.description = description;
        this.answer = answer;
        this.puzzleID = puzzleID;
        this.roomID = roomID;
    }

    public Puzzle() {
        this.description = description;
        this.answer = answer;
        this.puzzleID = puzzleID;
        this.roomID = roomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(String puzzleID) {
        this.puzzleID = puzzleID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                ", puzzleID='" + puzzleID + '\'' +
                ", roomID='" + roomID + '\'' +
                '}';
    }
}
