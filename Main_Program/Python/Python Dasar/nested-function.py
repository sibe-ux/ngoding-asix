def decorate(style='italic'):
    def italicc(s):
        return '<i>' + s + '<i>'

    def bold(s):
        return '<b>' + s + '<b>'
    if style == 'italic':
        return italicc
    else:
        return bold


dec = decorate()
print(dec('hello'))
dec2 = decorate('bold')
print(dec2('hello'))

# output
# <i>hello<i>
# <b>hello<b>


def another_func():
    print('hello')

def outer_func():
    return another_func()

outer_func()
# output
# hello
