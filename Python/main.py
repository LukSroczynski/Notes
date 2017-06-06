import eco_build_helper_lib


# Files path
index_html_filepath = "../../../target/classes/templates/index.html"

# Find created manifest files and return a PATH to them
manifest_js_filepath = eco_build_helper_lib.scan_for_manifest_js_path()
manifest_js_map_filepath = eco_build_helper_lib.scan_for_manifest_js_map_path()

copy_img_from = "../js/img"
copy_img_to = "../../../target/classes/static/img"

# Add Slashes to index.html

eco_build_helper_lib\
    .add_slash_at_end_of_tag(index_html_filepath, "link")

eco_build_helper_lib\
    .add_slash_at_end_of_tag(index_html_filepath, "meta")


# Change Path in index.html
eco_build_helper_lib \
    .find_and_replace(index_html_filepath, "/static", "/eco/static")


# Change HTTP or resources PATH in manifest files

eco_build_helper_lib\
    .find_and_replace(manifest_js_filepath, "static", "eco/static")

eco_build_helper_lib \
    .find_and_replace(manifest_js_map_filepath, "static", "eco/static")

# Copy /img folder

eco_build_helper_lib \
    .copy_folder(copy_img_from, copy_img_to)
