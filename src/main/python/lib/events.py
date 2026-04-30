class EventDeduplicator:

    def __init__(self, time_window):
        self.time_window = time_window
        self.buffer = {}

    def insert(self, event_id, timestamp) -> bool:
        if event_id in self.buffer:
            last_timestamp = self.buffer[event_id]
            if timestamp - last_timestamp < self.time_window:
                return False  # Duplicate event, ignore it

        self.buffer[event_id] = timestamp
        return True  # New event, process it
    
if __name__ == "__main__":
    deduplicator = EventDeduplicator(time_window=10)

    print(deduplicator.insert("event1", 100))  # True, new event
    print(deduplicator.insert("event1", 105))  # False, duplicate within time window
    print(deduplicator.insert("event1", 111))  # True, new event after time window
    print(deduplicator.insert("event2", 120))  # True, new event
    print(deduplicator.insert("event2", 125))  # False, duplicate within time window