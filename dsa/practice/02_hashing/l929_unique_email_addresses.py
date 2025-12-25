"""
L929 - Unique Email Addresses

Problem: https://leetcode.com/problems/unique-email-addresses/
Idea: Collect distinct email in a set
Time: O(n * m) where n is number of emails, m is average length
Space: O(n)
"""

def num_unique_emails(emails):
    unique_emails = set()
    
    for email in emails:
        local, domain = email.split('@')
        
        # Remove dots and everything after '+'
        if '+' in local:
            local = local[:local.index('+')]
        local = local.replace('.', '')
        
        unique_emails.add(local + '@' + domain)
    
    return len(unique_emails)


if __name__ == "__main__":
    emails = ["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]
    print(f"Input: {emails}")
    print(f"Unique emails: {num_unique_emails(emails)}")
