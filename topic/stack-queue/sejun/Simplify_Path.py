class Solution:
    def simplifyPath(self, path: str) -> str:
        result = []
        for word in path.split('/'):
            if word == '.' or word == '':
                pass
            elif word =='..':
                if result:
                    result.pop()
            else:
                result.append(word)
        result_path = '/'.join(result)
        result_path = '/' + result_path
        return result_path

