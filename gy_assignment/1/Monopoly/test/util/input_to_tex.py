for i in range(1, 12):
    with open(str(i) + ".txt", "r") as fi:
        ss = fi.readlines()
        with open(str(i) + "-ou.txt", "w") as fo:
            res = "\\item \\begin{itemize} \\item \\textbf{Input}\n\n"
            fo.write(res)
            for s in ss:
                fo.write(s)
                fo.write("\n")
            fo.write("\\end{itemize}")
