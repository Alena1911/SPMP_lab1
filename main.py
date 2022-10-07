# Очищаем дубликаты, если числа идут более n раз подряд
def clean_duplicates(v, n):
    # текущее число
    cur_num = v[0]
    # временный лист
    tmp_lst = []
    # конечный лист
    end_vec = []
    for num in v:
        # если текущее число равно текущему элементу листа
        # добавляем во временный вектор текущий элемент листа v
        if cur_num == num:
            tmp_lst.append(num)
        else:
            # если во временном листе количество элементов <= n
            # добавляем его в конечный лист
            append_all_or_one(tmp_lst, end_vec, n)
            cur_num = num
            tmp_lst.append(num)
    # так как после цикла временный лист не обработан
    append_all_or_one(tmp_lst, end_vec, n)
    return end_vec


# Добавляем в список все элементы tmpVec, если их количество <= n, иначе только один элемент
def append_all_or_one(tmp_lst, end_lst, n):
    if len(tmp_lst) <= n:
        end_lst += tmp_lst
    else:
        end_lst.append(tmp_lst[0])
    tmp_lst.clear()


if __name__ == "__main__":
    lst = [4, 8, 8, 8, 8, 1, 1, 2, 2, 3, 3, 3]
    N = 2
    print(clean_duplicates(lst, N))
