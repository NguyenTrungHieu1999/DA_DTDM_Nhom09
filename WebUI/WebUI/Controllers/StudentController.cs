using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using WebUI.ApiServices;
using WebUI.Models;

namespace WebUI.Controllers
{
    public class StudentController : Controller
    {
        private readonly IStudentService _studentService;

        public StudentController(IStudentService studentService)
        {
            _studentService = studentService;
        }

        public async Task<IActionResult> Index()
        {
            var students = await _studentService.GetAllAsync();

            return View(students);
        }

        [HttpGet]
        public IActionResult Insert()
        {
            ViewBag.Success = null;
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Insert(InsertVm studentVm)
        {
            var result = await _studentService.InsertAsync(studentVm);

            ViewBag.Success = null;

            if (result)
            {
                ViewBag.Success = "Thêm sinh viên thành công";
            }

            return View();
        }

        [HttpGet]
        public async Task<IActionResult> Edit(string id)
        {
            var student = await _studentService.GetByIdAsync(id);

            ViewBag.Success = null;

            return View(student);
        } 

        [HttpPost]
        public async Task<IActionResult> Edit(InsertVm studentVm)
        {
            var result = await _studentService.EditAsync(studentVm.id, studentVm);

            ViewBag.Success = null;

            if (result)
            {
                ViewBag.Success = "Cập nhật sinh viên thành công.";
            }

            return View();
        }
    }
}
