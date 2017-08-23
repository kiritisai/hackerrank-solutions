"""
Question URL: https://www.hackerrank.com/challenges/gridland-metro
"""

class track:
    def __init__(self, c1, c2):
        self.ranges = [(c1, c2)]
        self.total_range = []


    def append(self, newc1, newc2):
        self.ranges.append((newc1, newc2))


    def union(self):
        # Combine them if there is a common content
        for start, end in sorted(self.ranges):
            if self.total_range and self.total_range[-1][1] >= start-1:
                self.total_range[-1][1] = max(self.total_range[-1][1], end)
            else:
                self.total_range.append([start, end]) #Using list because tuples don't support assingment

    def track_blocks(self):
        total = 0 
        for start, end in self.total_range:
            total += end-start+1
        return total


    def print_ranges(self):
        print(",".join([str(r) for r in self.ranges]))


    def __repr__(self):
        result = []
        for r in self.total_range:
            result.append(str(r))
        return ",".join(result)


n,m,k = [int(number) for number in input().split()]

track_info = {}
for _ in range(k):
    r, c1, c2 = [int(i) for i in input().split()]
    if r in track_info:
        track_info[r].append(c1, c2) 
    else:
        track_info[r] = track(c1, c2) 


# Compress all the track info
for t in track_info.keys():
    track_info[t].union()
    #print(t, track_info[t])


# Count the number of track blocks
track_blocks = 0 
for t in track_info.keys():
    track_blocks += track_info[t].track_blocks()

#print(track_blocks)
print(n*m - track_blocks)
