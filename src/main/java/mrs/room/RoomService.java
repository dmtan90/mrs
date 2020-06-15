package mrs.room;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoomService {

    private final MeetingRoomRepository meetingRoomRepository;

    public RoomService(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    @NewSpan
    public MeetingRoom findMeetingRoom(@SpanTag Integer roomId) {
        return this.meetingRoomRepository.findById(roomId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "存在しない会議室です。"));
    }
}
