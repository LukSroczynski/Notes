from glob import glob
import shutil
import os


def add_slash_at_end_of_tag(file_link, tag):

    read_file = open(file_link, 'r')  # r - read

    changed_file = ""
    array_to_return = []

    # Make new lines at end of each tag
    for line in read_file:
        for ch in line:
            changed_file += ch
            if(ch == ">"):
                changed_file += "\n"

    # Make list
    temp=""
    for i in changed_file:
        temp += i
        if "\n" in i:
            array_to_return.append(temp)
            temp=""

    new_list = []

    # Find links
    for i in array_to_return:

        if i.find(tag) != -1:
            x = i.replace('>', '/>')
            # print("REPLACED:  " + x)
            new_list.append(x)
        else:
            new_list.append(i)

    to_file = ""
    for i in new_list:
        to_file += i

    write_file = open(file_link, 'w')  # r - read  # w - write
    write_file.write("".join(new_list))
    read_file.close()
    write_file.close()


def scan_for_manifest_js_path():
    filename = glob("../../../target/classes/static/js/manifest.*.js")[0]
    return filename.replace("\\", "/")


def scan_for_manifest_js_map_path():
    filename = glob("../../../target/classes/static/js/manifest*.js.map")[0]
    return filename.replace("\\", "/")


def find_and_replace(filepath, find, replace):

    # Read file: find and replace path
    read_file = open(filepath, 'r')  # r - read
    changed_file = read_file.read().replace(find, replace)
    read_file.close()

    # Write to file: Save changes
    write_file = open(filepath, 'w') # w - write
    write_file.write(changed_file)
    write_file.close()


def copy_folder(copy_from, copy_to):
    if os.path.exists(copy_to):
        shutil.rmtree(copy_to)
    shutil.copytree(copy_from, copy_to)
