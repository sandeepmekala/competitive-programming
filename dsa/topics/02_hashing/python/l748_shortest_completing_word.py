"""
L748 - Shortest Completing Word

Problem: https://leetcode.com/problems/shortest-completing-word/
Idea: Count char freq and compare
Time: O(n*m) where n is number of words, m is average word length
Space: O(1) - limited to 26 letters
"""

def shortest_completing_word(license_plate, words):
    # Count frequency of letters in license plate
    plate_count = {}
    for ch in license_plate.lower():
        if ch.isalpha():
            plate_count[ch] = plate_count.get(ch, 0) + 1
    
    result = ""
    min_length = float('inf')
    
    for word in words:
        # Count frequency of letters in current word
        word_count = {}
        for ch in word:
            word_count[ch] = word_count.get(ch, 0) + 1
        
        # Check if word contains all required letters
        is_completing = True
        for ch, count in plate_count.items():
            if word_count.get(ch, 0) < count:
                is_completing = False
                break
        
        # Update result if this word is shorter
        if is_completing and len(word) < min_length:
            min_length = len(word)
            result = word
    
    return result

if __name__ == "__main__":
    license_plate = "1s3 PSt"
    words = ["step", "steps", "stripe", "stepple"]
    print(f"Input: license_plate = '{license_plate}', words = {words}")
    print(f"Output: {shortest_completing_word(license_plate, words)}")
