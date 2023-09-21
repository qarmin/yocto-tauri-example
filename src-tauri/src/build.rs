use std::fs;
use std::path::Path;

fn main() {
    let build_path = Path::new("../dist");
    
    if !build_path.exists() {
        fs::create_dir(build_path).expect("Failed to create build dir");
    }

  tauri_build::build();
}
