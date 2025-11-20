from types import GeneratorType
import sys


def d(*args) -> None:
    import traceback
    from pprint import pprint
    traceback.print_stack(limit=-len(traceback.extract_stack()) + 1)
    for val in args:
        print(str(type(val)), file=sys.stderr)
        if isinstance(val, GeneratorType):
            i = 0
            for val_1 in val:
                pprint(val_1, sort_dicts=False, stream=sys.stderr)
                if i > 20:
                    print('...', file=sys.stderr)
                    break
                i += 1
        else:
            pprint(val, sort_dicts=False, stream=sys.stderr)
        #pprint(val, width=9999, sort_dicts=False, stream=sys.stderr)
        print('-' * 80)
    # print(repr(traceback.format_stack()))
    sys.exit(1)
